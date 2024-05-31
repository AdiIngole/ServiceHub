package com.adi.ServiceHub.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.adi.ServiceHub.dto.EmailGenerate;
import com.adi.ServiceHub.dto.ServiceProviderFinal;
import com.adi.ServiceHub.dto.ServiceProviderRequest;
import com.adi.ServiceHub.dto.User;
import com.adi.ServiceHub.dto.Validation;
import com.adi.ServiceHub.service.AdminService;
import com.adi.ServiceHub.service.AppointmentService;
import com.adi.ServiceHub.service.DesignationService;
import com.adi.ServiceHub.service.EmailGenerateService;
import com.adi.ServiceHub.service.FeedbackService;
import com.adi.ServiceHub.service.ServiceProviderService;
import com.adi.ServiceHub.service.UserService;
import com.adi.ServiceHub.service.ValidationService;

@Controller
public class ServiceProviderController {

	@Autowired
	AdminService adminService;

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	DesignationService designationService;

	@Autowired
	EmailGenerateService emailGenerateService;

	@Autowired
	FeedbackService feedbackService;

	@Autowired
	ServiceProviderService serviceProviderService;

	@Autowired
	UserService userService;

	@Autowired
	ValidationService validationService;

	// =======get service provider profile=====
	@GetMapping("/getSpProfile")
	public String getSpProfile(HttpSession session, ModelMap modelMap) {
		String uname = (String) session.getAttribute("sp_uname");
		ServiceProviderFinal sp = new ServiceProviderFinal();
		sp.setUserName(uname);
		List<ServiceProviderFinal> list = serviceProviderService.getSpProfile(sp);
		modelMap.put("list", list);
		return "ServiceProviderProfile";
	}

	// ====get image of service provider for profile===
	@GetMapping("/getImageSpProfile")
	public void getSpImageProfile(HttpServletResponse response, HttpSession session) throws SQLException, IOException {
		String uname = (String) session.getAttribute("sp_uname");
		ServiceProviderFinal s = new ServiceProviderFinal();
		s.setUserName(uname);
		// response.setContentType("image/jpeg/jpg");
		Blob image = serviceProviderService.getSpImageProfile(s);
		byte[] photo = image.getBytes(1, (int) image.length());
		InputStream inputstream = new ByteArrayInputStream(photo);
		IOUtils.copy(inputstream, response.getOutputStream());
	}

	// ====================== service provider logout /end login session
	@RequestMapping("/serviceProviderLogout")
	public ModelAndView spLogout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("sp_uname");
		session.invalidate();
		mv.setViewName("ServiceProviderLogin");
		return mv;
	}

	// =========================update password===============================
	@RequestMapping("/UpdateSpPassword")
	public ModelAndView updateSpPassword(@RequestParam("uname") String uname, @RequestParam("pass") String password) {
		ModelAndView mv = new ModelAndView();
		/*
		 * ServiceProviderFinal sp = new ServiceProviderFinal(); sp.setUserName(uname);
		 * sp.setPassword(password);
		 */
		ServiceProviderFinal serviceProviderFinal = serviceProviderService.getServiceProviderFinalByUserName(uname);
		serviceProviderFinal.setUserName(uname);
		serviceProviderFinal.setPassword(password);
		int count = serviceProviderService.updateSpPassword(serviceProviderFinal);
		if (count > 0) {
			mv.addObject("msg", "your password is updated successfully..");
		} else {
			mv.addObject("msg", "Sorry,your password updation is faield.");
		}
		return mv;
	}

	// validate the otp of service provider for update password when sp forget
	// password
	@RequestMapping("/validSpOtp")
	public ModelAndView validateSpOtp(@RequestParam("otp") String otp, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.setAttribute("spuotp", otp);
		String spotp = (String) session.getAttribute("spotp");
		if (spotp.equals(otp)) {
			mv.setViewName("UpdateSpPassword");
		} else {
			mv.addObject("otpmsg", "please enter valid otp");
			mv.setViewName("SpGetOtpForFpass");
		}
		return mv;
	}

	// validate service provider email id and username and send otp mail
	@RequestMapping("/validSpForfpass")
	public ModelAndView getValidateSpEmailUname(@RequestParam("uname") String uname,
			@RequestParam("email") String email, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Validation v = new Validation();
		v.setUsername(uname);
		v.setEmail(email);
		int count = validationService.getValidSpEmailUname(v);
		if (count > 0) {
			String otp = validationService.getOtp();
			session.setAttribute("spotp", otp);
			EmailGenerate eg = new EmailGenerate();
			eg.setReciption(email);
			eg.setSubject("Regarding otp");
			eg.setMessage("your otp for forget password is  :  " + otp);
			emailGenerateService.sendEmail(eg);
		} else {
			mv.addObject("msg", "Plese enter valid user name and email id .. ");
		}
		mv.setViewName("SpGetOtpForFpass");
		return mv;
	}

	// ====================service provider login validation and maintain session
	@PostMapping("/ServiceProviderLogin")
	public String validServiceProvider(@RequestParam("uname") String uname, @RequestParam("pwd") String pass,
			HttpSession session, ModelMap modelMap) {
		Validation v = new Validation();
		v.setUsername(uname);
		v.setPassword(pass);
		int a = validationService.serviceProviderValidation(v);
		if (a > 0) {
			session.setAttribute("sp_uname", uname);
			return "ServiceProviderHome";
		} else {
			modelMap.put("msg", "please enter valid username and password");
			return "ServiceProviderLogin";
		}
	}

	// ============get client appointment list

	@RequestMapping("/getClient")
	public String getClient(@RequestParam("sp_uname") String uname, ModelMap modelMap) {
		List<User> list = serviceProviderService.getClient(uname);
		System.out.println();
		modelMap.put("list", list);
		return "ClientForSp";
	}

	// ======send service provider request for registration...
	@RequestMapping(value = "/ServiceProviderRegistration", method = RequestMethod.POST)
	public ModelAndView getview(HttpServletRequest request, @RequestParam("photo") MultipartFile photo,
			@RequestParam("qualification") MultipartFile qcertificate, @RequestParam("licence") MultipartFile licence,
			@RequestParam("adhard") MultipartFile adharimg) {
		ModelAndView mv = new ModelAndView();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobNumber = request.getParameter("mob");
		String mail = request.getParameter("email");
		String adhar_number = request.getParameter("adhar");
		String designation = request.getParameter("design");
		String gender = request.getParameter("gender");
		String date_of_birth = request.getParameter("date");
		String specialization = request.getParameter("specialization");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String tahsil = request.getParameter("taluka");
		String district = request.getParameter("dist");
		String state = request.getParameter("state");
		String qualification = request.getParameter("hqualification");
		String univercity = request.getParameter("univercity");
		String experiance = request.getParameter("experiance");
		String username = request.getParameter("username");
		String password = request.getParameter("password1");

		ServiceProviderRequest sp = new ServiceProviderRequest();
		sp.setFname(fname);
		sp.setLname(lname);
		sp.setMobNumber(mobNumber);
		sp.setEmail(mail);
		sp.setAadharNumber(adhar_number);
		sp.setGender(gender);
		sp.setDateofbirth(date_of_birth);
		sp.setSpecialization(specialization);
		sp.setOfficeAddress(address);
		sp.setCity(city);
		sp.setTahsil(tahsil);
		sp.setDistrict(district);
		sp.setState(state);
		sp.setHighQualification(qualification);
		sp.setUniversityName(univercity);
		sp.setExperiance(experiance);
		sp.setQualificationCertificate(getByte(qcertificate));
		sp.setLicenceCertificate(getByte(licence));
		sp.setPhoto(getByte(photo));
		sp.setAadharImage(getByte(adharimg));
		sp.setUserName(username);
		sp.setPassword(password);
		sp.setDesignation(designation);
		int a = serviceProviderService.saveOrUpdateServiceProvider(sp);
		if (a > 0) {
			mv.addObject("rmsg", "your registration reqeust is sucessfully done..");
			EmailGenerate eg = new EmailGenerate();
			eg.setMessage(
					"your registration request process is done. you will get within 2 days response from Service Hub. your user name is : "
							+ username + "  and password is  : " + password);
			eg.setSubject("Related to service provider registration request..");
			eg.setReciption(mail);
			emailGenerateService.sendEmail(eg);
		} else {
			mv.addObject("rmsg", "your reqeust is field..");
		}
		mv.setViewName("ServiceProviderLogin");
		return mv;
	}

	private byte[] getByte(MultipartFile multipartFile) {
		byte[] bytes = null;
		try {
			bytes = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}
}

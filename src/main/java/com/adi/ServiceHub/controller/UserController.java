package com.adi.ServiceHub.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adi.ServiceHub.dto.Appointment;
import com.adi.ServiceHub.dto.Designation;
import com.adi.ServiceHub.dto.EmailGenerate;
import com.adi.ServiceHub.dto.ServiceProviderFinal;
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
public class UserController {

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

	// ========================show user profile=====================
	@RequestMapping("/getUserProfile")
	public ModelAndView getUserProfile(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String uname = (String) session.getAttribute("cuname");
		List<User> list = userService.getUserByUserName(uname);
		mv.addObject("list", list);
		mv.setViewName("UserProfile");
		return mv;
	}

	// =======update user password====================================
	@PostMapping("/UpdateUserPassword")
	public ModelAndView getUpdateUserPassword(@RequestParam("uname") String uname, @RequestParam("pass") String pass) {
		ModelAndView mv = new ModelAndView();
		User user = userService.getUserByUserName(uname).get(0);
		if (user != null) {
			user.setUsername(uname);
			user.setPassword(pass);
		}
		int count = userService.saveOrUpdateUser(user);
		System.out.println(count);
		if (count > 0) {
			mv.addObject("msg", "your password is successfuly updated..");
		} else {
			mv.addObject("msg", "plse enter valide user name..");
		}
		mv.setViewName("UpdateUserPassword");
		return mv;
	}

	// ====validate otp for forget password====================================
	@RequestMapping("/validUserOtp")
	public ModelAndView getValidUserotp(@RequestParam("otp") String otp, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.setAttribute("uu_otp", otp);
		String sotp = (String) session.getAttribute("uotp");
		if (sotp.equals(otp)) {
			mv.setViewName("UpdateUserPassword");
		} else {
			mv.addObject("otpmsg", "plase enter valid otp");
			mv.setViewName("UserGetOtpFpass");
		}
		return mv;
	}

	// =====validate user and mail id for getting forget password otp====
	@GetMapping("/validUserForfpass")
	public ModelAndView getValidUser(@RequestParam("uname") String uname, @RequestParam("email") String email,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Validation v = new Validation();
		v.setUsername(uname);
		v.setEmail(email);
		int a = validationService.getValidUserEmail(v);
		if (a > 0) {
			String otp = validationService.getOtp();
			session.setAttribute("uotp", otp);
			EmailGenerate eg = new EmailGenerate();
			eg.setReciption(email);
			eg.setSubject("Regarding otp");
			eg.setMessage("your otp for forget password is  :" + otp);
			emailGenerateService.sendEmail(eg);
		} else {
			mv.addObject("msg", "Plese enter valid user name and email id .. ");
		}
		mv.setViewName("UserGetOtpFpass");
		return mv;

	}

	// ==========do user validation and maintain session..
	@GetMapping("/userLoginValidation")
	public String doUserLoginValidation(@RequestParam("uname") String uname, @RequestParam("pwd") String password,
			HttpSession session, ModelMap modelMap) throws IOException {
		int a = 0;
		Validation v = new Validation();
		v.setUsername(uname);
		v.setPassword(password);
		a = validationService.userValidation(v);
		if (a > 0) {
			session.setAttribute("cuname", uname);
			return "UserHome";
		} else {
			modelMap.put("msg", "please enter valid user name and password");
			return "UserLogin";
		}
	}

	// ======do user logout operation...
	@RequestMapping("/UserlogOut")
	public String getuLogout(HttpSession session, ModelMap modelMap) {
		session.removeAttribute("cuname");
		session.invalidate();
		return "UserLogin";
	}

	// =================get list of services available in our web application for
	// user
	@RequestMapping("/getDesignation")
	public ModelAndView getDesignation() throws IOException {
		ModelAndView mv = new ModelAndView();
		List<Designation> dlist = designationService.getAllDesignations();
		mv.addObject("list", dlist);
		mv.setViewName("UserServices");
		return mv;
	}

	// get list designation related service provider list ...
	@RequestMapping("/DrelatedSP")
	public ModelAndView getDrelatedSp(@RequestParam("des") String designation) {
		ModelAndView mv = new ModelAndView();
		List<ServiceProviderFinal> list = serviceProviderService.getDrelatedSp(designation);
		mv.addObject("list", list);
		mv.setViewName("showDrelatedSp");
		return mv;
	}

	// =====get list designation related service provider image list..
	@RequestMapping("/getDrelatedImg")
	public void getDrelatedImg(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		// response.setContentType("image/jpeg/jpg");
		Blob image = serviceProviderService.getSpImage(id);
		byte[] photo = image.getBytes(1, (int) image.length());
		InputStream inputstream = new ByteArrayInputStream(photo);
		IOUtils.copy(inputstream, response.getOutputStream());
	}

	// == get all service provider list for the user...
	@RequestMapping("/getAllSpForUser")
	public ModelAndView getAllSpForUser() {
		ModelAndView mv = new ModelAndView();
		List<ServiceProviderFinal> list = serviceProviderService.getServiceProvider();
		mv.addObject("list", list);
		mv.setViewName("AllSpForUser");
		return mv;
	}

	// ===== get all service provider images list...
	@RequestMapping("/AllSpForUserImg")
	public void getAllSpImageForUser(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		response.setContentType("image/jpeg/jpg");
		Blob image = serviceProviderService.getSpImage(id);
		byte[] photo = image.getBytes(1, (int) image.length());
		InputStream inputstream = new ByteArrayInputStream(photo);
		IOUtils.copy(inputstream, response.getOutputStream());
	}

	// ==do user registration operation...
	@PostMapping("/createUser")
	public ModelAndView registerUser(HttpServletRequest request) {
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String email = request.getParameter("emailId");
		String mobileno = request.getParameter("mobileNo");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String tahasil = request.getParameter("taluka");
		String district = request.getParameter("district");
		String state = request.getParameter("state");
		String dob = request.getParameter("dob");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ModelAndView mv = new ModelAndView();
		User user = new User();
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(email);
		user.setMobilenumber(mobileno);
		user.setGender(gender);
		user.setAddress(address);
		user.setCity(city);
		user.setTahasil(tahasil);
		user.setDistrict(district);
		user.setState(state);
		user.setDateofbirth(dob);
		user.setUsername(username);
		user.setPassword(password);
		user.setIsAppointmentScheduled(false);
		user.setIsRejected(false);
		int count = userService.saveOrUpdateUser(user);
		if (count > 0) {
			EmailGenerate eg = new EmailGenerate();
			eg.setMessage(
					"your registration in service hub is successfully done.Well come to the service hub family .your user name is: "
							+ username + " your password is  :" + password);
			eg.setSubject("Regarding Service hub registration");
			eg.setReciption(email);
			emailGenerateService.sendEmail(eg);
			mv.addObject("rmsg", "your registration is successfully done. now you can login");
		}
		mv.addObject("rmsg", "sorry your registration is failed..");
		mv.setViewName("UserLogin");
		return mv;
	}

	// ===fix appointment to the user....
	@RequestMapping("/getAppointmentAll")
	public ModelAndView getAppointmentAll(@RequestParam("cuname") String cuname,
			@RequestParam("spuname") String spuname, @RequestParam("spemail") String spemail) {
		ModelAndView mv = new ModelAndView();
		Appointment a = new Appointment();
		a.setSpuname(spuname);
		a.setCuname(cuname);
		a.setSpemail(spemail);
		a.setAppointmentDateTime(LocalDateTime.now().plusHours(2));
		appointmentService.saveOrUpdateAppointment(a);
		mv.setViewName("redirect:/getAllSpForUser");
		return mv;
	}

	// ==== fix appointment designation related service provider
	@RequestMapping("/getAppointmentDrsp")
	public ModelAndView getAppointment(@RequestParam("cuname") String cuname, @RequestParam("spuname") String spuname,
			@RequestParam("spemail") String spemail) {
		ModelAndView mv = new ModelAndView();
		Appointment a = new Appointment();
		a.setSpuname(spuname);
		a.setCuname(cuname);
		a.setSpemail(spemail);
		LocalDateTime appointmeDateTime = LocalDateTime.now().plusHours(2);
		a.setAppointmentDateTime(appointmeDateTime);
		appointmentService.saveOrUpdateAppointment(a);
		User user = userService.getUserByUserName(cuname).get(0);
		user.setIsRejected(false);
		userService.saveOrUpdateUser(user);
		EmailGenerate eg = new EmailGenerate();
		eg.setReciption(spemail);
		eg.setSubject("Regarding Appointment");
		eg.setMessage("Your appointment has been scheduled at ".concat(appointmeDateTime.toString())
				.concat(". wait for Service Provider acceptance"));
		emailGenerateService.sendEmail(eg);
		mv.setViewName("redirect:/getDesignation");
		return mv;
	}

	// ==== fix appointment designation related service provider
	@RequestMapping("/acceptAppointmentDrsp")
	public ModelAndView acceptAppointmentDrsp(HttpSession session, @RequestParam("fname") String fname,
			@RequestParam("lname") String lname, @RequestParam("email") String email) {
		ModelAndView mv = new ModelAndView();
		User user = userService.getUserByFnameAndLnameAndEmail(fname, lname, email);
		user.setIsAppointmentScheduled(true);
		userService.saveOrUpdateUser(user);
		EmailGenerate eg = new EmailGenerate();
		eg.setReciption(email);
		eg.setSubject("Regarding Appointment Acceptance");
		eg.setMessage("Your appointment has been fixed at scheduled time");
		emailGenerateService.sendEmail(eg);
		String uname = (String) session.getAttribute("sp_uname");
		mv.setViewName("redirect:/getClient?sp_uname=" + uname);
		return mv;
	}

	// ==== fix appointment designation related service provider
	@RequestMapping("/rejectAppointmentDrsp")
	public ModelAndView rejectAppointmentDrsp(HttpSession session, @RequestParam("fname") String fname,
			@RequestParam("lname") String lname, @RequestParam("email") String email) {
		ModelAndView mv = new ModelAndView();
		User user = userService.getUserByFnameAndLnameAndEmail(fname, lname, email);
		user.setIsAppointmentScheduled(false);
		user.setIsRejected(true);
		userService.saveOrUpdateUser(user);
		EmailGenerate eg = new EmailGenerate();
		eg.setReciption(email);
		eg.setSubject("Regarding Appointment Rejection");
		eg.setMessage("Your appointment has been rejected, please schedule appointment again.");
		emailGenerateService.sendEmail(eg);
		String uname = (String) session.getAttribute("sp_uname");
		mv.setViewName("redirect:/getClient?sp_uname=" + uname);
		return mv;
	}

}

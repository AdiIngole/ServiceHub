package com.adi.ServiceHub.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.adi.ServiceHub.dto.Admin;
import com.adi.ServiceHub.dto.Designation;
import com.adi.ServiceHub.dto.EmailGenerate;
import com.adi.ServiceHub.dto.Feedback;
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
public class AdminController {

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

	@RequestMapping("/")
	public String home(Model model) {
		return "Home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		return "About";
	}

	@RequestMapping("/contact")
	public String contact(Model model) {
		return "Contact";
	}

	@RequestMapping("/adminlogin")
	public String adminlogin(Model model) {
		return "AdminLogin";
	}

	@RequestMapping("/userlogin")
	public String userlogin(Model model) {
		return "UserLogin";
	}

	@RequestMapping("/serviceProviderLogin")
	public String ServiceProviderLogin(Model model) {
		return "ServiceProviderLogin";
	}

	@RequestMapping("/adminGetOtpForfpass")
	public String AdminGetOtpForfpass(Model model) {
		return "AdminGetOtpForfpass";
	}

	@RequestMapping("/otpValidationAdminRegistration")
	public String OtpValidationAdminRegistration(Model model) {
		return "OtpValidationAdminRegistration";
	}

	@RequestMapping("/adminRegistration")
	public String AdminRegistration(Model model) {
		return "AdminRegistration";
	}

	@RequestMapping("/AddDesignation")
	public String AddDesignation(Model model) {
		return "AddDesignation";
	}

	@RequestMapping("/AdminAbout")
	public String AdminAbout(Model model) {
		return "AdminAbout";
	}

	@RequestMapping("/AdminHome")
	public String AdminHome(Model model) {
		return "AdminHome";
	}

	@RequestMapping("/userGetOtpFpass")
	public String userGetOtpForfpass(Model model) {
		return "UserGetOtpFpass";
	}

	@RequestMapping("/userRegistration")
	public String userRegistration(Model model) {
		return "UserRegistration";
	}

	@RequestMapping("/userHome")
	public String userHome(Model model) {
		return "UserHome";
	}

	@RequestMapping("/userAbout")
	public String userAbout(Model model) {
		return "UserAbout";
	}

	@RequestMapping("/serviceProviderHome")
	public String serviceProviderHome(Model model) {
		return "ServiceProviderHome";
	}

	@RequestMapping("/serviceProviderAbout")
	public String serviceProviderAbout(Model model) {
		return "ServiceProviderAbout";
	}

	@RequestMapping("/spGetOtpForFpass")
	public String spGetOtpForFpass(Model model) {
		return "SpGetOtpForFpass";
	}

	// get feedbcak list from database==================
	@GetMapping(value = "/getFeedback")
	public String getFeedback(ModelMap map) {
		List<Feedback> list = feedbackService.getAllFeedback();
		map.put("list", list);
		return "Feedback";
	}

	// delete feedback for database
	@SuppressWarnings("unused")
	@GetMapping("/deleteFeedback")
	public String deletFeedback(@RequestParam("fid") int fid) {
		Feedback f = new Feedback();
		f.setFid(fid);
		int a = feedbackService.deleteFeedback(f);
		return "redirect:/getFeedback";
	}

	// insert feedback
	@PostMapping("/insertFeedback")
	public String insertFeedback(@RequestParam("name") String name, @RequestParam("position") String position,
			@RequestParam("feedback") String feedback, @RequestParam("mob") String mob,
			@RequestParam("mail") String mail, ModelMap modelMap) {
		Feedback f = new Feedback();
		f.setName(name);
		f.setPosition(position);
		f.setFeedback(feedback);
		f.setMob(mob);
		f.setMail(mail);
		int count = feedbackService.saveOrUpdateFeedback(f);
		if (count > 0) {
			modelMap.put("fmsg", "you feedback is successfully send...");
		} else {
			modelMap.put("fmsg", "you feedback send is failed");
		}
		return "Contact";
	}

	// get Admin profile
	@RequestMapping("/getAdminProfile")
	public String getAdminProfile(HttpSession session, ModelMap modelMap) {
		String uname = (String) session.getAttribute("auname");
		Admin a = new Admin();
		a.setUsername(uname);
		List<Admin> list = adminService.getAdminsByUserName(uname);
		modelMap.put("list", list);
		return "AdminProfile";
	}

	// Admin logout or admin username session exite
	@RequestMapping("/adminLogout")
	public String getAdminLogout(HttpSession session, ModelMap modelMap) {
		session.removeAttribute("auname");
		session.invalidate();
		return "AdminLogin";
	}

	// updating admin password
	@PostMapping("/UpdateAdminPassword")
	public String updateAdminPassword(@RequestParam("uname") String uname, @RequestParam("pass") String pass,
			ModelMap modelMap) {
		Admin admin = adminService.getAdminsByUserName(uname).get(0);
		if (admin != null) {
			admin.setUsername(uname);
			admin.setPassword(pass);
		}
		int count = adminService.saveOrUpdateAdmin(admin);
		if (count > 0) {
			modelMap.put("umsg", "your password is updated successfuly completed");
			return "AdminLogin";
		} else {
			modelMap.put("msg", "plse try again something is wrong");
			return "UpdateAdminPassword";
		}
	}

	// get validate otp for admin forget password
	@GetMapping("/getValidateOtpForfpass")
	public String getValidateOtpForfpass(@RequestParam("otp") String otp, HttpSession session, ModelMap map) {
		String adminotp = (String) session.getAttribute("adminotp");
		if (adminotp.equals(otp)) {
			return "UpdateAdminPassword";
		} else {
			map.put("otpmsg", "pls enter valid otp");
			return "AdminGetOtpForfpass";
		}
	}

	// validate admin username and email and send otp for forget passowrd
	@GetMapping("/validAdminEmailUname")
	public String getValidEmailUname(@RequestParam("email") String email, @RequestParam("uname") String uname,
			HttpSession session, ModelMap modelMap) {
		Validation v = new Validation();
		v.setEmail(email);
		v.setUsername(uname);
		int count = validationService.getValidAdminEmailUname(v);
		if (count > 0) {
			String otp = validationService.getOtp();
			session.setAttribute("adminotp", otp);
			EmailGenerate eg = new EmailGenerate();
			eg.setReciption(email);
			eg.setSubject("Regarding otp");
			eg.setMessage("your otp for forget password is  :  " + otp);
			emailGenerateService.sendEmail(eg);
		} else {
			modelMap.put("msg", "Plese enter valid user name and email id .. ");
		}
		return "AdminGetOtpForfpass";
	}

	// Admin Registration======================
	@PostMapping("/createAccount")
	public String adminRegistration(@RequestParam("uname") String uname, @RequestParam("pass") String pass,
			@RequestParam("email") String email, ModelMap modelMap) {
		Admin a = new Admin();
		a.setUsername(uname);
		a.setPassword(pass);
		a.setEmail(email);
		int count = adminService.saveOrUpdateAdmin(a);
		if (count > 0) {
			modelMap.put("rmsg", "your account is succefully created");
			return "AdminLogin";
		} else {
			modelMap.put("msg", "Sorry somthing is wrong pls try agian");
			return "AdminRegistration";
		}
	}

	// validate admin otp for registration====
	@GetMapping("/validateAdminOtpRegistration")
	public String getvalidateOtp(HttpSession session, @RequestParam("otp") String otp, ModelMap modelMap) {
		session.setAttribute("auotp", otp);
		String sotp = (String) session.getAttribute("aotp");
		if (sotp.equals(otp)) {
			return "AdminRegistration";
		} else {
			modelMap.put("msg", "plse enter valid otp");
			return "OtpValidationAdminRegistration";
		}
	}

	// ==============get otp for new admin registration=====
	@GetMapping("/getOtpForAdminRegisration")
	public String getOtp(HttpSession session, ModelMap modelMap) {
		EmailGenerate eg = new EmailGenerate();
		String otp = validationService.getOtp();
		session.setAttribute("aotp", otp);
		eg.setReciption("adiingole1006@gmail.com");
		eg.setMessage("yoru otp is  : " + otp);
		eg.setSubject("regarding otp");
		emailGenerateService.sendEmail(eg);
		return "OtpValidationAdminRegistration";
	}

	// ==========get service provider list===============================
	@GetMapping("/getServiceProvider")
	public String getServiceProvider(ModelMap modelMap) {
		List<ServiceProviderFinal> list = serviceProviderService.getServiceProvider();
		modelMap.put("list", list);
		return "ServiceProviderView";
	}

	// ==============get service provider
	// images=====================================

	@GetMapping("/getSPimgae")
	public void getSpImage(@RequestParam("id") int id, HttpServletResponse response) throws SQLException, IOException {
		// response.setContentType("image/jpeg/jpg");
		Blob image = serviceProviderService.getSpImage(id);
		loadImage(response, image);
	}

	// ============get service provider Adhar card image
	// ==================================
	@GetMapping("/getSpAdharImage")
	public void getSpAdharImage(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		Blob spadhar = serviceProviderService.getSpAdharImage(id);
		loadImage(response, spadhar);
	}
	// =========get service provider licence
	// image===============================================

	@GetMapping("/getSplicence")
	public void getSpLicence(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		Blob licence = serviceProviderService.getSpLicence(id);
		loadImage(response, licence);
	}

	// =============get service provider qualification
	// image======================================

	@GetMapping("/getSpQualificationImg")
	public void getSpQualificationImag(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		Blob qimage = serviceProviderService.getSpQualificationImg(id);
		loadImage(response, qimage);
	}

	// ==========get service provider list of registration
	// request=================================================

	@RequestMapping("/spregistration_request")
	public String getSPreqeust(ModelMap modelMap) {
		List<ServiceProviderRequest> list = serviceProviderService.getList();
		modelMap.put("list", list);
		return "ServiceProviderRequestView";
	}

	// =======get service provider image of registration
	// request=============================

	@GetMapping("/getSPImage_req")
	public void getSPimageRequest(@RequestParam("id") int id, HttpServletResponse response)
			throws IOException, SQLException {
		Blob image = serviceProviderService.getspRequestImage(id);
		loadImage(response, image);
	}

	// ===============get service provider licence image for registration reqeust
	@GetMapping("/getSplicence_req")
	public void getSpLicenceRequest(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		Blob licence = serviceProviderService.getspReqeustlicence(id);
		loadImage(response, licence);
	}
	
	// ==========get service provider adhar image for registration reqeust========
	@GetMapping("/getSpAdharImage_req")
	public void getSpAdharimageRequest(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		Blob adharimg = serviceProviderService.getspRequestAddarImage(id);
		loadImage(response, adharimg);
	}

	// ==========get service provider qualification images of registration
	// request================

	@GetMapping("/getSpQualification_req")
	public void getSpcQualificationRequest(@RequestParam("id") int id, HttpServletResponse response)
			throws SQLException, IOException {
		Blob qualification = serviceProviderService.getspRequestQcertificate(id);
		loadImage(response, qualification);
	}

	// ========reject service provider registration
	// request====================================
	@GetMapping("/RejectServiceProvider")
	public String rejectServiceProvider(@RequestParam("id") int id, @RequestParam("mail") String rmail,
			ModelMap modelMap) {
		int count = serviceProviderService.rejectServiceProvider(id);
		if (count > 0) {
			EmailGenerate eg = new EmailGenerate();
			eg.setReciption(rmail);
			eg.setSubject("regarding service hub verification");
			eg.setMessage(
					"Sorry in your document verification process we got some fault.plse apply agin with valid douments..");
			emailGenerateService.sendEmail(eg);
		}
		return "spregistration_request";
	}

	// ===========get all user list =================
	@RequestMapping("/getAllusers")
	public String getAlluser(ModelMap modelMap) {
		List<User> list = userService.getAll();
		modelMap.put("list", list);
		return "Alluser";
	}

	// ======delete the user ======
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		userService.deleteUser(id);
		mv.setViewName("redirect:/getAllusers");
		return mv;
	}

	// =========Accept service provider registration request====

	@RequestMapping("/acceptSpRequest")
	public String acceptSpRequest(@RequestParam("id") int id, @RequestParam("mail") String rmail) {
		// ModelAndView mv = new ModelAndView();
		int count = serviceProviderService.acceptSpRequest(id);
		if (count > 0) {
			EmailGenerate eg = new EmailGenerate();
			eg.setReciption(rmail);
			eg.setSubject("related to service hub registration");
			eg.setMessage("your verification is succeffully complited.Well come to the service Hub family...");
			emailGenerateService.sendEmail(eg);
		}
		// mv.setViewName("redirect:/spregistration_request");
		// return mv;
		return "redirect:/spregistration_request";
	}

	// ==========add designation for the user=====
	@PostMapping("/addDesignation")
	public String addSpDesignation(@RequestParam("designation") String designation, ModelMap modelMap) {
		Designation d = new Designation();
		d.setDesignation(designation);
		int count = designationService.saveOrUpdateDesignation(d);
		if (count > 0) {
			modelMap.put("msg", "successfully insert");
		} else if (count == -1) {
			modelMap.put("msg", "Designation already exist");
		} else {
			modelMap.put("msg", "insertion failed");
		}
		return "AddDesignation";
	}

	// ========after adding designation show the registration page for service
	// provider
	@GetMapping("/Serviceprovider")
	public ModelAndView getDesignation() {
		ModelAndView mv = new ModelAndView();
		List<Designation> designation = designationService.getAllDesignations();
		mv.addObject("des", designation);
		mv.setViewName("ServiceProviderRegistration");
		return mv;
	}

	// ======delete service provider in admin section
	@RequestMapping("/deleteSp")
	public ModelAndView deleteSp(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		serviceProviderService.deleteSrviceProvider(id);
		mv.setViewName("redirect:/getServiceProvider");
		return mv;
	}

	// =======Admin login validation
	@GetMapping("/adminLoginValidation")
	public String getAdminValidation(HttpSession session, @RequestParam("uname") String uname,
			@RequestParam("pwd") String password, ModelMap map) {
		Validation v = new Validation();
		v.setUsername(uname);
		v.setPassword(password);
		int count = validationService.adminValidation(v);
		if (count > 0) {
			session.setAttribute("auname", uname);
			return "AdminHome";
		} else {
			map.put("msg", "Enter valid user name and password");
			return "AdminLogin";
		}
	}
	
	private InputStream getFileFromResourceAsStream(String fileName) {
		// The class loader that loaded the class
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(fileName);

		// the stream holding the file content
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {
			return inputStream;
		}
	}

	public void loadImage(HttpServletResponse response, Blob image) {
		InputStream inputstream = null;
		try {
			if (image.length() >= 1) {
				byte[] bytes = image.getBytes(1, (int) image.length());
				inputstream = new ByteArrayInputStream(bytes);
			} else {
				/* String fileName = "static/image/no-image-available-icon.jpg"; */
				String fileName = "static/image/no-image-icon.png";
				//String fileName = "static/image/No_image_available.png";
				System.out.println("getResourceAsStream : " + fileName);
				inputstream = getFileFromResourceAsStream(fileName);
			}
			IOUtils.copy(inputstream, response.getOutputStream());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}

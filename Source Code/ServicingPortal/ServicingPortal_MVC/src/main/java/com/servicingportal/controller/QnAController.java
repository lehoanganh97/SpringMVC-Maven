package com.servicingportal.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.servicingportal.dao.QnACatelogyDAO;
import com.servicingportal.dao.QnADAO;
import com.servicingportal.entity.EmployeeAccount;
import com.servicingportal.entity.QnA;
import com.servicingportal.entity.QnACatelogy;
import com.servicingportal.lib.ManagerSession;
/*QuyDH Create New QnAController 23/10/2018*/
@Controller
public class QnAController {
	@Autowired
	QnADAO qnaDAO;
	
	@Autowired
	QnACatelogyDAO qnaCatelogyDAO;
	@RequestMapping(value = "/question/send",method = RequestMethod.POST)
	public String question(String strQnACusEmail,String strQnAContent, String iQnACatID,Model model, HttpServletRequest request){
		String referrer = request.getHeader("referer");
		if(strQnACusEmail.trim().equals("") || strQnAContent.trim().equals("")){
			model.addAttribute("question","null");
			return "redirect:" + referrer;
		}		
		QnA qna = new QnA();
		qna.setCreateDate(new Date());
		QnACatelogy qnaCatelogy = qnaCatelogyDAO.getQnACatelogyByID(Integer.parseInt(iQnACatID));
		qna.setQnacatelogy(qnaCatelogy);
		qna.setQnACusEmail(strQnACusEmail);
		qna.setQnAContent(strQnAContent);
		boolean check = qnaDAO.createQnA(qna);
		if(check){
			model.addAttribute("question","true");
			return "redirect:" + referrer;
		}
		model.addAttribute("question","false");
		return "redirect:" + referrer;
	}
	/*QuyDH Update Function Controller 30/10/2018*/
	@RequestMapping(value="/employee/listQuestion")
	public String listQnA(Model model, HttpServletRequest request){
		EmployeeAccount employee = ManagerSession.userEmployee(request);
		if(employee == null){
			return "redirect:/employee/login";
		}
		List<QnA> liQnA = qnaDAO.listQnA();
		model.addAttribute("listQnA",liQnA);
		return "question/listQnA";
	}
	
	@RequestMapping(value = "/employee/listquestionwaiting")
	public String listQuestionWait(Model model, HttpServletRequest request){
		EmployeeAccount employee = ManagerSession.userEmployee(request);
		if(employee == null){
			return "redirect:/employee/login";
		}
		List<QnA> liQnA = qnaDAO.listQnANullAnwser();
		model.addAttribute("listQnA",liQnA);
		return "question/listQnA";
	}
	
	@RequestMapping(value = "/employee/question/{id}",method = RequestMethod.GET)
	public String answer(@PathVariable("id") int id, Model model, HttpServletRequest request){
		EmployeeAccount employee = ManagerSession.userEmployee(request);
		if(employee == null){
			return "redirect:/employee/login";
		}
		System.out.println(id);
		QnA qna = qnaDAO.getQnAByID(id);
		model.addAttribute("qna",qna);
		return "question/answerform";
	}
	
	@RequestMapping(value = "/employee/saveanswer/{id}", method = RequestMethod.GET)
	public String save(@PathVariable("id") int id, Model model, HttpServletRequest request){
		EmployeeAccount employee = ManagerSession.userEmployee(request);
		if(employee == null){
			return "redirect:/employee/login";
		}
		QnA qna = qnaDAO.getQnAByID(id);
		if(qna == null){
			return "redirect:/employee/listQuestion";
		}
		String strAnswer = request.getParameter("strAnswer");
		if(strAnswer == null){
			model.addAttribute("result","null");
			return "redirect:/employee/question/"+id;
		}
		System.out.println(strAnswer);
		if(strAnswer.trim().equals("")){
			return "Chưa nhập câu trả lời";
		}
		qna.setQnAReplyContent(strAnswer);
		qna.setEmployeeaccount(employee);
		qna.setQnAReplyDate(new Date());
		qna.setQnAISReply((byte) 1);
		boolean check = qnaDAO.editQnaA(qna);
		if(check){
			return "redirect:/employee/listQuestion";
		}
		model.addAttribute("result","false");
		return "redirect:/employee/question/"+id;
	}
	/*QuyDH EndUpdate 30/10/2018*/
}

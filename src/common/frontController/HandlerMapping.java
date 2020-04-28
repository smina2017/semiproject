package common.frontController;

import java.util.HashMap;

import common.exception.Status404;
import up.index.controller.IndexController;
import up.member.controller.MemberController;
import up.mypage.controller.MyPageController;

public class HandlerMapping {

	private HashMap<String, Controller> list = null;

	public HandlerMapping() {
		list = new HashMap<String, Controller>();
		list.put("index", new IndexController());
		list.put("member", new MemberController());
		list.put("mypage", new MyPageController());
	}

	public Controller getController(String[] uriArr) throws Status404 {
		Controller res = list.get(uriArr[2]);

//		현재 servlet이기 때문에 404로 예외를 명시해줬다.
		if (res == null) {
			throw new Status404("uri를 다시 확인해주세요");
		}

		return res;
	}

	public String getMethod(String[] uriArr) throws Status404 {
		String methodName = "";

		switch (uriArr[2]) {
		case "index":
			switch (uriArr[3]) {
			case "index.do":
				methodName = "index";
				break;
			case "detail.do":
				methodName = "detail";
				break;
			default:
				throw new Status404("uri를 다시 확인 해주세요!");
			}
			break;
		case "member":
			switch (uriArr[3]) {
			case "login.do":
				methodName = "login";
				break;
			case "register.do":
				methodName = "register";
				break;
			case "forgotid.do":
				methodName = "forgotId";
				break;
			case "forgotpwd.do":
				methodName = "forgotPwd";
				break;
			case "emailcheck.do":
				methodName = "emailCheck";
				break;
			default:
				throw new Status404("uri를 다시 확인 해주세요!");
			}
			break;
		case "mypage":
			switch (uriArr[3]) {
			case "mypage.do":
				methodName = "myPage";
				break;
			case "infopwdcheck.do":
				methodName = "infoPwdCheck";
				break;	
			case "pwpwdcheck.do":
				methodName = "pwPwdCheck";
				break;
			case "habithistory.do":
				methodName = "habitHistory";
				break;
			case "titlelist.do":
				methodName = "titleList";
				break;
			case "memberwithdrawal.do":
				methodName = "memberWithdrawal";
				break;
			case "infomodify.do":
				methodName = "infoModify";
				break;	
			case "passwordmodify.do":
				methodName = "passwordModify";
				break;
			default:
				throw new Status404("uri를 다시 확인 해주세요!");	
			}
			break;
		case "book":
			break;
		case "use":
			break;
		case "notice":
			switch (uriArr[3]) {
			case "notice.do":
				methodName = "notice";
				break;
			default:
				throw new Status404("uri를 다시 확인해주세요!");
			}
			break;
		default:
			throw new Status404("uri를 다시 확인해주세요!");
		}
		return methodName;
	}

}

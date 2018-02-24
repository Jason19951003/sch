package sch.web.controllerImpl;

public class TchController extends AbstractController {

	@Override
	public String getUserNo() {
		return (String) this.getRequestBean().getSession().getAttribute("tch_no");
	}

	@Override
	public String getUserName() {
		return (String) this.getRequestBean().getSession().getAttribute("tch_name");
	}

}

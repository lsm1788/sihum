package controller;

import controllerAction.Action;
import controllerAction.BoardDeleteAction;
import controllerAction.BoardListAction;
import controllerAction.BoardUpdateAction;
import controllerAction.BoardUpdateFormAction;
import controllerAction.BoardViewAction;
import controllerAction.BoardWriteAction;
import controllerAction.BoardWriteFormAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory(); 
	private ActionFactory() {
		super();
	}
	public static ActionFactory getInstance() {
		return instance;
	}
	//인터페이스 요청 command를 if문으로 분석해주면 해당 요청정보에 따른 클래스를 선택한다.
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory :" + command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		} else if (command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")) {
			action = new BoardWriteAction();
		} else if (command.equals("board_view")) {
			action = new BoardViewAction();
		}  else if (command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if (command.equals("board_update")) {
			action = new BoardUpdateAction();
		} else if (command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}
		return action;
	}
}

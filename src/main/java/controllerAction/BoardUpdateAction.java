package controllerAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardVO bVo = new BoardVO();
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		bVo.setWriter(request.getParameter("writer"));
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateBoard(bVo);
		new BoardListAction().execute(request, response);
	}

}

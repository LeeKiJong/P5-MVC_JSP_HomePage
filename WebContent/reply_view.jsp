<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css_folder/assets/css/main.css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>답변 작성 페이지</title>
</head>
<body>
	<section id="four" class="main">
	<div class="container">
		<div class="content">
			<section>
			<table width="500" cellpadding="0" cellspacing="0" border="1">
				<form action="reply.do" method="post">
					<input type="hidden" name="bId" value="${reply_view.bId}">
					<input type="hidden" name="bName" value="${name}"> <input
						type="hidden" name="bGroup" value="${reply_view.bGroup}">
					<input type="hidden" name="bStep" value="${reply_view.bStep}">
					<input type="hidden" name="bIndent" value="${reply_view.bIndent}">
					<tr>
						<td>번호</td>
						<td>${reply_view.bId}</td>
					</tr>
					<tr>
						<td>히트</td>
						<td>${reply_view.bHit}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${name}</td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="bTitle"
							value="${reply_view.bTitle}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea rows="10" name="bContent">${reply_view.bContent}</textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="답변"> <a
							href="list.do">목록</a></td>
					</tr>
				</form>
			</table>


			</section>


		</div>
	</div>
	</section>



</body>
</html>
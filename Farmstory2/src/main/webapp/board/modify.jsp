<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/_header.jsp"/>
<jsp:include page="./_${group}.jsp"/>
<main id="board">
    <section class="modify">

        <form action="/Farmstory2/board/modify.do">
        	<input type="hidden" name="group" value="${group}"/>
        	<input type="hidden" name="cate" value="${cate}"/>
        	<input type="hidden" name="pg" value="${pg}"/>
        	<input type="hidden" name="no" value="${no}"/>
        	<input type="hidden" name="uid" value="${sessUser.uid}"/>
            <table border="0">
                <caption>글수정</caption>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" placeholder="제목을 입력하세요." value="${article.title}"/></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                        <textarea name="content" value="${article.cotent}"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>파일</th>
                    <td>
                        <input type="file" name="fname" value="${article.fname}"/>
                    </td>
                </tr>
            </table>
            
            <div>
                <a href="./view.do?group=${group}&cate=${cate}&no=${no}&pg=${pg}" class="btn btnCancel">취소</a>
                <input type="submit" value="작성완료" class="btn btnComplete"/>
            </div>
        </form>

    </section>
</main>
</article>
    </section>
</div>
<jsp:include page="/WEB-INF/_footer.jsp"/>
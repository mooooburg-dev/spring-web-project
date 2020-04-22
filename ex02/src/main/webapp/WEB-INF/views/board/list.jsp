<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../includes/header.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		var result = '<c:out value="${result}"/>';

		checkModal(result);

		history.replaceState({}, null, null);

		function checkModal(result){
			if(result === '' || history.state){
				return;
			}

			if(parseInt(result) > 0){
				$('.modal-body').html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
			}
			$('#myModal').modal("show");
		}

		$('#regBtn').on("click", function(){
			self.location = "/board/register";
		});

		//
		var actionForm = $("#actionForm");

		$('.paginate_button a').on('click', function(e){
			e.preventDefault();

			console.log('click');

			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		})

		//
		$(".move").on("click", function(e){
			e.preventDefault();

			actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
			actionForm.attr("action", "/board/get");
			actionForm.submit();
		})
	});
</script>
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">Tables</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
	        <div class="panel panel-default">
	            <div class="panel-heading">
	                Board List Page
	                <button id="regBtn" type="button" class="btn btn-xs pull-right">Register New Board</button>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <table width="100%" class="table table-striped table-bordered table-hover">
	                    <thead>
	                        <tr>
	                            <th>#번호</th>
	                            <th>제목</th>
	                            <th>작성자</th>
	                            <th>작성일</th>
	                            <th>수정일</th>
	                        </tr>
	                    </thead>
	                    
	                    <c:forEach items="${list}" var="board">
	                    
		                    <tr>
		                    	<td><c:out value="${board.bno}"/></td>
		                    	<td><a class="move" href='<c:out value="${board.bno}"/>'><c:out value="${board.title}"/></a></td>
		                    	<td><c:out value="${board.writer}"/></td>
		                    	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
		                    	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }"/></td>
		                    </tr>
	                    </c:forEach>
	                </table>
	                <!-- /.table-responsive -->
	                
	                <div class="pull-right">
	                	<ul class="pagination">
	                		<c:if test="${pageMaker.prev}">
	                			<li class="paginate_button previous">
	                				<a href="${pageMaker.startPage-1 }">Previous</a>
	                			</li>
	                		</c:if>
	                		
	                		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage }">
	                			<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active": ""}">
	                				<a href="${num }">${num }</a>
	                			</li>
	                		</c:forEach>
	                		
	                		<c:if test="${pageMaker.next}">
	                			<li class="paginate_button next">
	                				<a href="${pageMaker.endPage + 1 }">Next</a>
	                			</li>
	                		</c:if>
	                	</ul>
	                	
	                	<form id="actionForm" action="/board/list" method="get">
	                		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
	                		<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
	                	</form>
	                </div>
	                <!-- end Pagination -->
	                
	                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                	<div class="modal-dialog">
	                		<div class="modal-content">
	                			<div class="modal-header">
	                				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                				<h4 class="modal-title" id="myModalLabel">Modal title</h4>
	                			</div>
	                			<div class="modal-body">처리가 완료되었습니다.</div>
	                			<div class="modal-footer">
	                				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	                				<button type="button" class="btn btn-primary">Save changes</button>
	                			</div>
	                		</div>
	                	</div>
	                
	                </div>
	            </div>
	            <!-- /.panel-body -->
	        </div>
	        <!-- /.panel -->
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
            
            
<%@ include file="../includes/footer.jsp" %>
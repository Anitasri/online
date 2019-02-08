<h1 class="my-4">FOOD STOP</h1>
          <div class="list-group">
          
          <c:forEach items="${categories}" var="category">
          
          <a href="${contextRoot}/show/category/${category.id}/items" class="list-group-item" 
          id="a_${category.name}">
          <h3>${category.name}</h3></a>
  
          </c:forEach>
            
          </div>

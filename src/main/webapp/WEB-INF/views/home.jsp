<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>

<html>
    <head>
        <title>Online Shopping</title>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/cart.js"></script>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div>
            <table>
                <tr>
                    <th>Код</th>
                    <th>Название</th>
                    <th>Цена</th>
                    <th>Количество</th>
                </tr>
                <c:forEach items="${itemList}" var="stuck">
                    <tr>
                        <td>${stuck.code}</td>
                        <td>${stuck.name}</td>
                        <td id=${stuck.id}>${stuck.price}</td>
                        <td>
                            <input type="text" placeholder="0" size="3" name=${stuck.id}>
                            <input type="button" value="Добавить в корзину" data-name="${stuck.id}" id="addtocart" class="bun">
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="cart">
            <div id="quantity">предметов в коризне ${cart.totalQuantity}</div>
            <div id="price">сумма к оплате ${cart.totalPrice}</div>
            <div>
                <input type="button" value="очистить корзину" id="clean">
                <input type="button" value="детализация" id="detail">
            </div>
        </div>
        <div class="b-popup" id="popup1">
            <div class="b-popup-content" id="order"></div>
            <div id="cart_form">
                <input type="button" value="венуться к выбору товаров" id="detailclose">
                <input type="button" value="сохранить заказ в базу данных" id="persist">
            </div>
        </div>
    </body>
</html>

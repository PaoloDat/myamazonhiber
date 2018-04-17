function PopUpShow(){
    $("#popup1").show();
}
function PopUpHide(){
    $("#popup1").hide();
}
$(document).ready(function () {
    PopUpHide();
    $('#detail').click(function () {
        $("#popup1").show();
    });
    $('#detailclose').click(function () {
        $("#popup1").hide();
    });
    $('#persist').click(function () {
        $.ajax({
            type: "GET",
            url: "savecart",
            success: function (text)
            {
                alert(text);
            }
        })
    })


    $(':button.bun').click(function () {
        var id = $(this).data('name'),
            qnt = $("input[name='" +id+ "']").val(),
            pr = $("td[id='" +id+ "']").html();

        $.ajax({
            type: "GET",
            url: "addtocart",
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data: {id: Number(id), price: pr, quantity: Number(qnt)},
            success:function (data) {
                $('#quantity').text("предметов в корзине " + data.totalQuantity);
                $('#price').text("сумма к оплате " + data.totalPrice);
                var sum=0;
                $.each(data.order, function (i, item) {
                    sum += item.total;
                });
                var trHTML = '<table><tr><th>Код</th><th>Название</th><th>Цена</th><th>Количество</th><th>Общая стоимость</th></tr>';
                $.each(data.order, function (i, item) {
                    trHTML += '<tr><td>' + item.code + '</td><td>' + item.name + '</td><td>' + item.price + '</td><td>' + item.quantity + '</td><td>' + item.total + '</td></tr>';
                });
                trHTML += '<tr><td colspan="4" align="right">'+'всего к оплате'+'</td><td align="right">'+sum+'</td></tr>';
                trHTML += '</table>'
                $('#order').empty();
                $('#order').append(trHTML);

            }
        })
    })

    $('#clean').click(function () {
        $.ajax({
            type: "GET",
            url: "cleancart",
            success:function (data) {
                $('#quantity').text("предметов в корзине " + data.totalPrice);
                $('#price').text("сумма к оплате " + data.totalQuantity);
            }
        })
    })

})
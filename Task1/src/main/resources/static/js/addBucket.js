function dispatchToBucket(user_id, car_id, count) {
    $.ajax({
        type: "POST",
        url: "/addToBucket",
        data: {
            "userId": user_id,
            "carId": car_id,
            "count": count
        },
        error: function (data) {
            alert(data.status)
        },
        success: function (data) {
            alert("Товар добавлен в корзину")
        }
    });
}
function updateUser(id, name, homeTown, email, password) {
    $.ajax({
        type: "POST",
        url: "/update_profile?id=" + id,
        data: {
            "name": name,
            "homeTown": homeTown,
            "email": email,
            "password": password
        },
        error: function (data) {
            alert(data.status)
        },
        success: function (data) {
            alert("Изменения успешно сохранены")
        }
    });
}
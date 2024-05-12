// (1) 회원정보 수정
function update(userId) {
    let data = $("#profileUpdate").serialize();

    $.ajax({
        type:"put",
        url:`apu/user/${userId}`,
        data: data,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType:"json"
    }).done(res=>{
        console.log("update 성공");
    }).fail(error=>{
        console.log("update 실패");
    });
}
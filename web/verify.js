let flag=new Array();
function name_verify() {
    let name=document.getElementById("name");
    let reg=/^[\u0391-\uFFE5]+$/;
    name.onblur=function () {
        this.nextElementSibling.style.display="block";
        if(name.value.length==0){
            this.focus();
            this.nextElementSibling.innerHTML="不能为空";
            this.nextElementSibling.style.color="red";
        }else{
            if(reg.test(name.value)){
                this.nextElementSibling.style.color="green";
                this.nextElementSibling.innerHTML="格式正确";
                flag.push(true);
            }else{
                this.focus();
                this.nextElementSibling.style.color="red";
                this.nextElementSibling.innerHTML="格式不正确";
            }
        }
    }
}
function gender_verify() {

}
function address_verify() {

}
function qq_verify() {
    let qq=document.getElementById("qq");
    let reg=/^[1-9]\d{4,9}$/;
    qq.onblur=function () {
        this.nextElementSibling.style.display="block";
        if(this.value.length==0){
            this.focus();
            this.nextElementSibling.innerHTML="不能为空";
            this.nextElementSibling.style.color="red";
        }else{
            if(reg.test(this.value)){
                this.nextElementSibling.style.color="green";
                this.nextElementSibling.innerHTML="格式正确";
                flag.push(true);
            }else{
                this.focus();
                this.nextElementSibling.style.color="red";
                this.nextElementSibling.innerHTML="格式不正确";
            }
        }
    }

}
function email_verify() {
    let email=document.getElementById("email");
    let reg=/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    email.onblur=function () {
        this.nextElementSibling.style.display="block";
        if(this.value.length==0){
            this.focus();
            this.nextElementSibling.innerHTML="不能为空";
            this.nextElementSibling.style.color="red";
        }else{
            if(reg.test(this.value)){
                this.nextElementSibling.style.color="green";
                this.nextElementSibling.innerHTML="格式正确";
                flag.push(true);
            }else{
                this.focus();
                this.nextElementSibling.style.color="red";
                this.nextElementSibling.innerHTML="格式不正确";
            }
        }
    }
}
function addsubmit() {
    if(flag.length==0){
        confirm("请填写信息！");
    }else if(flag.length>0&&flag.length<3){
        confirm("未填写完整信息！");
    }else{
        document.getElementById("addform").submit();
    }
}


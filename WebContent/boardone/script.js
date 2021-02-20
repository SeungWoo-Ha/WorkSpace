function writeSave(){
		if(documenet.writeForm.writer.value == ""){
			alert("작성자를 입력하시요.");
			document.writeForm.writer.focus();
			return false;
		}
		if(documenet.writeForm.subject.value == ""){
			alert("제목을 입력하시요.");
			document.writeForm.subject.focus();
			return false;
		}
		if(documenet.writeForm.content.value == ""){
			alert("내용을 입력하십시요.");
			document.writeForm.content.focus();
			return false;
		}	
		if(documenet.writeForm.pass.value == ""){
			alert(" 비밀번호를 입력하시요.");
			document.writeForm.pass.focus();
			return false;
		}	
}
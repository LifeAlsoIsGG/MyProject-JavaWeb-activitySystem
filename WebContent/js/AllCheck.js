/**
 * 
 */
/*ȫѡ��ȡ��ȫѡ*/
function allcheck(){
	var oBtn1 = document.getElementById('btn1');
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked = true;
	}
	
}

function allcanclecheck(){
	var oBtn2 = document.getElementById('btn2');
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked = false;
	}
	
}



/*����ɾ���û�,���ɾ������ˣ�����˱�Ҳ��ɾ����Ӧ����*/
function DelAllUser(){
	var alluser = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			alluser.push(oCheck[i].value);	
			flag = true;
		}
	}
	if(flag){/*��ȷ��Ҫɾ����Щ��¼����ѡ��*/
		if(confirm("Are you sure to delete these record?")){
			location.href="UpdateUser?f=delall&Uname="+alluser;
/*			location.href="UpdateExaminer?f=delall&Uname="+alluser;*/
		}
	}	
		else{
		alert("Please choose one at least befor delete!");
	
  }
}
	
	
	
function DelAllActivity(){
		var allactivity = new Array();
		var flag = false;
		var oCheck = document.getElementsByName('check');
		for(var i=0;i<oCheck.length;i++){
			if(oCheck[i].checked){
				allactivity.push(oCheck[i].value);	
				flag = true;
			}
		}
		if(flag){/*��ȷ��Ҫɾ����Щ��¼����ѡ��*/
			if(confirm("Are you sure to delete these record?")){
				location.href="UpdateActivity?f=delall&Aid="+allactivity;
			}
		}	
			else{
			alert("Please choose one at least befor delete!");
		
	  }	
}
	

	
	
/*
	����ɾ�������
function DelAllExaminer(){
	var allexaminer = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			allexaminer.push(oCheck[i].value);
			flag = true;
		}
	}
	if(flag){��ȷ��Ҫɾ����Щ��¼����ѡ��
		if(confirm("Are you sure to delete these record?")){
			location.href="UpdateExaminer?f=delall&Eid="+allexaminer;
		}
	}	
		else{
		alert("Please choose one at least befor delete!");
		
	 }
	}*/


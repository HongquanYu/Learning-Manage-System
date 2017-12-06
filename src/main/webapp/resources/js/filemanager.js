function uploadSyllabus(){
    var formData = new FormData();
    var file = $('#fileToBeUploaded')[0].files[0];
    if (file){
    	console.log("Made it here");
    	formData.append('file', file);
    	var syllabus = 'Syllabus';
    	var courseId = $('#courseId').attr('value');
    	var filename = syllabus + "-" + courseId;
    	formData.append('filename', filename);
    	$.ajax({
    		url:'storeFile.htm',
    		data: formData,
    		processData: false,
    		contentType: false,
    		type: 'POST',
    		success : function (data){
    		    confirm(data);
    		}
    	})
    }
}

function downloadSyllabusFile(file){
	$("#" + file).submit();
	return false;
}


function uploadAssignment(){
	console.log("Made it here");

    var formData = new FormData();
    var file = $('#fileToBeUploaded2')[0].files[0];
    if (file){
    	console.log("Made it here");
    	formData.append('file', file);
    	var courseId = $('#courseId').attr('value');
    	var userId = $('#userID').attr('value');
    	
    	
    	var assignmentName = document.getElementById('AssignmentName').value;

    	//var assignmentName = $('#AssignmentName').attr('value');
    	var filename = courseId + "-" + assignmentName + "-" + userId;
    	formData.append('filename', filename);
    	$.ajax({
    		url:'storeAssignment.htm',
    		data: formData,
    		processData: false,
    		contentType: false,
    		type: 'POST',
    		success : function (data){
    		    confirm(data);
    		}
    	})
    }
}

function downloadAssignmentFile(file){
	$("#" + file).submit();
	return false;
}
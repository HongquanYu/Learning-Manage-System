function uploadSyllabus(){
    var formData = new FormData();
    var file = $('#fileToBeUploaded')[0].files[0];
    if (file){
    	formData.append('file', file);
    	var syllabus = 'Syllabus';
    	var userId = $('#userID').attr('value');
    	var courseId = $('#courseId').attr('value');
    	var filename = syllabus + "-" + userId + "-" + courseId;
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
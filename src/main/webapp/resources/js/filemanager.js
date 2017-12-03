function uploadSyllabus(){
    var formData = new FormData();
    var file = $('#fileToBeUploaded')[0].files[0];
    if (file){
    	formData.append('file', file);
    	var filename = 'syllabus';
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
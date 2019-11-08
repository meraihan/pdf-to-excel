$("#issueAddForm").submit(function (e) {
    e.preventDefault();

    var formData = new FormData();
    var pdf_file = $("#pdf_file").val();

    formData.append("pdffile", pdf_file);
    $.ajax({
        url: "/convert",
        data: formData,
        processData: false,
        contentType: false,
        type: "POST",
        success: function (data) {
            console.log("file converted successfully");
        },
        error: function (data) {
            console.log("error - " + data.responseText);
        }
    });

});
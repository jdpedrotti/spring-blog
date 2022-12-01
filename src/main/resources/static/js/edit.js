$(document).ready(function(){
    $(".editButton").on('click', function(e){
        window.location.replace(`/posts/${$(this).attr("data-id")}/edit`);
    });
});
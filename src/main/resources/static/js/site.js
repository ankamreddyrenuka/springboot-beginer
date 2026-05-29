
// Highlight active navbar link based on current path
document.addEventListener('DOMContentLoaded', function(){
  try{
    var links = document.querySelectorAll('.navbar a');
    var path = window.location.pathname || '/';
    links.forEach(function(a){
      var href = a.getAttribute('href');
      if(!href) return;
      // treat root
      if(href === path || (href === '/' && path === '/')){
        a.classList.add('active');
      }
    });
  }catch(e){
    // ignore
  }
});
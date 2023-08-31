//Navegeacion Menu Lateral
function AbrirMenu() {
	if (!document.getElementById("icono").className.match(/(?:^|\s)abierto(?!\S)/)) {
		if (document.getElementById("menuLateral").className.match(/(?:^|\s)animated(?!\S)/)) {
			document.getElementById("menuLateral").className = document.getElementById("menuLateral").className.replace(/(?:^|\s)abierto animated slideOutLeft(?!\S)/g, '');
		}
		document.getElementById("icono").className += " abierto";
		document.getElementById("menuLateral").className += " abierto animated slideInLeft";
	} else {
		document.getElementById("menuLateral").className += " abierto animated slideOutLeft";
		document.getElementById("icono").className = document.getElementById("icono").className.replace(/(?:^|\s)abierto(?!\S)/g, '');
	}
}

//Slider Principal
window.addEventListener('load', function() {
	var sliderContainer = document.querySelector('.sliderPrincipalCont');
	var sliderImages = document.querySelectorAll('.sliderPrincipalCont img');
	var currentIndex = 0;

	setInterval(function() {
		currentIndex = (currentIndex + 1) % sliderImages.length;
		var transformValue = (currentIndex * -100) / sliderImages.length;
		sliderContainer.style.transform = 'translateX(' + transformValue + '%)';
	}, 4000);
});










document.addEventListener('DOMContentLoaded', function() {
	const submenus = document.querySelectorAll('.has-submenu');
	document.addEventListener('click', function(event) {
		for (const submenu of submenus) {
			if (!submenu.contains(event.target)) {
				submenu.querySelector('.submenu').style.display = 'none';
			}
		}
	});

	submenus.forEach(function(submenu) {
		const submenuTrigger = submenu.querySelector('a');
		submenuTrigger.addEventListener('click', function(event) {
			event.preventDefault();
			const subMenuList = submenu.querySelector('.submenu');
			if (subMenuList.style.display === 'block') {
				subMenuList.style.display = 'none';
			} else {
				subMenuList.style.display = 'block';
			}
		});
	});
});



function universalclose() {
	if(!$.browser.msie){
		window.open('','_parent','');
	}
	window.close();
}
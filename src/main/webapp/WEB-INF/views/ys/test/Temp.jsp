<ul id="uploadedList" class="mailbox-attachments clearfix">

</ul>

<script id="templateAttach" type="text/x-handlebars-template">
<li data-src="{{fullName}}">
	<span class="mailbox-attachment-icon has-img">
		<img src="{{imgsrc}}" alt="Attachment">
	</span>
	<div class="mailbox-attachment-info">
		<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
	</div>
</li>
</script>
<<script type="text/javascript">

$.getJSON('/sboard/getAttach/' + bno, function(rData) {
		console.log('rData', rData);
		var list = $(rData);
		list.each(function(index) {
			var fName = rData[index];
			
			// resouces/js/myfunc.js
			var data = getDataObject(fName);
			
			var source = $('#templateAttach').html();
			var template = Handlebars.compile(source);
			var templateData = template(data);
			$('#uploadedList').append(templateData);
			
		}); // list.each
	}); // $.getJSON
	<!--

//-->
</script>
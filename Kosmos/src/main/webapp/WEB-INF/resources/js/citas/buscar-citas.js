/**
 * 
 */
jQuery.datetimepicker.setLocale('es');
$(document).ready(function() {
  $('#idCalendario').datetimepicker({
	timepicker:false,
	format:'d/m/Y',
    onChangeDateTime: function(ct, $input) {
      console.log('onChange: ' + $input.val());
    },
    onClose: function(ct, $input) {
      console.log('close.');
    },
    onShow: function(ct, $input) {
      console.log('show.');
    }
  });
});
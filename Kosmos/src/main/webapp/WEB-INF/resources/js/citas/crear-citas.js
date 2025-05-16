/**
 * 
 */
$(document).ready(function() {
  $('#idCalendario').datetimepicker({
	allowTimes:['09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00'],
	format:'d/m/Y H:00',
    onChangeDateTime: function(ct, $input) {
      console.log('onChange: ' + $input.val());
    },
    onClose: function(ct, $input) {
      console.log('close.');
    },
    onShow: function(ct, $input) {
      console.log('show.');
    },
  });
});
(function () {
  'use strict'
  var forms = document.querySelectorAll('.needs-validation')
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }
        form.classList.add('was-validated')
      }, false)
    })
})()
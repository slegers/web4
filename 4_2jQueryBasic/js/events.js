$(function() {
  var ids = '';
  var $listItems = $('li');

  // mouseover and click because mouseover dos not work on touchscreen devices
  $listItems.on('mouseover click', function() {
    ids = this.id;
    $listItems.children('span').remove();
    $(this).append(' <span class="priority">' + ids + '</span>');
  });

  $listItems.on('mouseout', function() {
    $(this).children('span').remove();
  });

});
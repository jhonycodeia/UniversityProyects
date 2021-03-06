/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var a = document.querySelectorAll('.punto');
a = Array.prototype.slice.call(a);

a.forEach(function(el, i, ra) {
  var to = {
    x: Math.random() * (i % 2 === 0 ?-9 : 9),
    y: Math.random() * 10
  };
  
  el.animate([
    { transform: 'translate(0,0) scale(1)', opacity: 1 },
    { transform: 'translate('+to.x+'rem,'+to.y+'rem) scale('+Math.random()+')', opacity: Math.random() }
  ], {
    duration: (Math.random() + 1) * 2000,
    direction: 'alternate',
    fill: 'both',
    iterations: Infinity,
    easing: 'ease-in-out'
  });
});

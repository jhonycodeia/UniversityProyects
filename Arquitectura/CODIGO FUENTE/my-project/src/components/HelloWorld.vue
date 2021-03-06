<template>
 <div>
  <div>
    <input type="text" v-model="name"/>
    <input type="submit" v-on:click="getSaludo" value="Saludar" />
    
  </div>
  <h1>{{nombre}}</h1>
 </div>
</template>

<script>

import axios from 'axios';

export default {
  name: 'HelloWorld',
  props: {
    name: String,
    saludo: false,
    nombre:String
    
  },methods: {
    getSaludo: function() {
      
      axios.get('http://localhost:9090/HelloName/rest/controllers/saludo/saludoNombre/'+this.name).then((response) => {
       console.log(response.data);
       this.nombre = response.data.saludo+","+response.data.nombre;
    });
      
      
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>

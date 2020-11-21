<template>
    <div class="CreateEmergency">
        <b-container class="border border rounded mb-4" >
            <h2 class="p-3" align="center">Formulario de registro</h2>
            <b-alert v-model="Alert" :variant="estilo" dismissible class="mt-3">
                {{mensaje}}
            </b-alert>
            <b-form-group class="mt-2">
                <h6> <strong>RUN</strong></h6>
                
                <b-form-input
                    v-model="run"
                    required
                    placeholder="Ingrese su run (Ej: 12345678-9)"
                ></b-form-input>
            </b-form-group>

            <b-form-group class="mt-2">
               <b-row>
                  <b-col cols="4">
                <h6> <strong>Nombre</strong></h6>
                  </b-col cols="4">
                  <b-col cols="4">
                <h6> <strong>Primer apellido</strong></h6>
                  </b-col cols="4">

                  <b-col cols="4">
                <h6> <strong>Segundo apellido</strong> (Opcional)</h6>
                  </b-col cols="4">
             </b-row>
                <b-row>
                <b-col cols="4">
                  <b-form-input
                    v-model="first_name"
                    required
                    placeholder="Ingrese su nombre"
                  ></b-form-input>
               </b-col cols="4">

               <b-col cols="4">
                  <b-form-input
                    v-model="last_name"
                    required
                    placeholder="Ingrese su primer apellido"
                  ></b-form-input>
               </b-col cols="4">

               <b-col cols="4">
                  <b-form-input
                    v-model="last_name2"
                    placeholder="Ingrese su segundo apellido"
                  ></b-form-input>
               </b-col cols="4">
            </b-row>

            </b-form-group>

            <b-form-group class="mt-2">
                <h6> <strong>Correo electrónico</strong></h6>
                
                <b-form-input
                    v-model="email"
                    required
                    placeholder="Ingrese su email"
                ></b-form-input>
            </b-form-group>

                <b-form-group class="mt-2">
                <h6> <strong>Contraseña</strong></h6>
                <b-form-input 
                    :type="visibility"
                    v-model="password"
                    required
                    placeholder="Ingrese su contraseña"
                ></b-form-input>
            </b-form-group>

            <b-row class="mt- 2">
                <b-col>
                    <b-button block variant="outline-info" @click="verifyData"  >Crear</b-button>
                </b-col>
                <b-col>
                    <b-button block variant="outline-dark" v-on:click="redirigir()" >Cancelar</b-button>
                </b-col>
            </b-row>

      
        </b-container>
    </div>
</template>

<script>    

import axios from 'axios';
export default {
    name: 'Test',
    data:function(){
        return{
            run: '',
            password: '',
            first_name: '',
            last_name: '',
            last_name2: '',
            email: '',

            mensaje: '',
            visibility: 'password'
        }
    },

    props: {        
        placeholder: {type: String, default: ''},
        value: '',
        maxlength: {type: Number, default: 50},
        onlyunder: {type: Boolean, default: false}    
    },

    methods:{
        verifyData(){
            if(
                this.run != '' &&
                this.password != '' &&
                this.first_name != '' &&
                this.last_name != '' &&
                this.email != ''
            ){
                this.dataValidation = 1;

                axios.post('http://localhost:8080/user/add',{
                    run: this.run,
                    password: this.password,
                    first_name: this.first_name,
                    last_name: this.last_name,
                    last_name2: this.last_name2,
                    email: this.email
                }).then(this.mensaje="Creado correctamente!", this.Alert=true, this.estilo="success")
                .catch(error => {
                console.log(error)
                this.errored = true
                this.Alert=true
                this.mensaje="DATOS ERRONEOS!"
                this.estilo="danger"
                })
                .finally(this.loading=false)

                this.run = ''
                this.password = ''
                this.first_name = ''
                this.last_name = ''
                this.last_name2 = ''
                this.email = ''

                
            }            
            else {
                this.mensaje="Datos incompletos!"
                this.estilo="danger"
                this.Alert = true;
            }
        },
        showPassword() {
            this.visibility = 'text';
        },
        hidePassword() {
            this.visibility = 'password';
        }  
    },
    watch: {
        $route: {
            immediate: true,
            handler(to, from) {
                document.title = to.meta.title || 'Permisos distribuidos - Registro';
            }
        },
}}
</script>
<style>
.FindVoluntarie{
    display:flex;
    flex-direction: column;
}
#mapid {
    height: 400px;
    width: 1200px;
}
</style>
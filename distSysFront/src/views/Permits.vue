<template>
    <div class="CreateEmergency">
        <b-container class="border border rounded mb-4" >
            <h2 class="p-3" align="center">Formulario de solicitud de permiso</h2>
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

            <b-form-group>
                <h6><strong>Motivo</strong></h6>
                <b-row>
                    <b-col cols="3">
                        Indique su razón:
                    </b-col>
                    <b-col  cols="9">                    
                        <b-form-select  v-model="reason_id" >
                        <option v-for="reason in reasons" :key="reason.id" :value="reason.id">{{reason.description}}</option>
                        </b-form-select>
                    </b-col>
                </b-row>
            </b-form-group>
                
            </b-form-group>

            <b-row class="p-4">
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
    name: 'CreateEmergency',
    data() {
        const now = new Date()
        const today = new Date(now.getFullYear(), now.getMonth(), now.getDate())
        // 15th two months prior
        const minDate = new Date(today)

        return {
            run: '',
            first_name: '',
            last_name: '',
            last_name2: '',
            email: '',
            reason_id: '',
            user_id: '',

            mensaje: '',

            reasons: [],
            
      }
    },
    created(){
        this.getReasons()  
    },

    watch: {
        $route: {
            immediate: true,
            handler(to, from) {
                document.title = to.meta.title || 'Permisos distribuidos - Solicitud';
            }
        }
},

    methods: {
        showModal() {
        this.$refs['my-modal'].show()
        },
        async getReasons(){
            let datos = await axios.get('http://localhost:8080/reason/all')
            this.reasons=await datos.data
        },       
        redirigir(){
             window.location.href = '/'
        },
        verifyData(){
            if(
                this.run != '' &&
                this.password != '' &&
                this.first_name != '' &&
                this.last_name != '' &&
                this.email != '' &&
                this.reason_id != ''
            ){
                this.dataValidation = 1;

                axios.post('http://localhost:8080/form/add',{
                    run: this.run,
                    password: this.password,
                    first_name: this.first_name,
                    last_name: this.last_name,
                    last_name2: this.last_name2,
                    email: this.email,
                    reason_id: this.reason_id

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
                this.reason_id = ''
                this.email = ''

                
            }            
            else {
                this.mensaje="Datos incompletos!"
                this.estilo="danger"
                this.Alert = true;
            }
        }
    }
}

</script>
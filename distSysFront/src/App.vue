<template>
  <div id="app">
    <div class="p-3">
      <b-navbar toggleable="lg" type="dark" variant="info" active-class="active">
        

        <b-navbar-brand   :to="{name: 'Dashboard'}">Permisos</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
        
        <b-collapse id="nav-collapse" is-nav>
          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto">
            <b-nav-item :to="{name: 'Permits'}">Solicitar Permiso</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>

    <b-container>
      <router-view/>
    </b-container>
  </div>
</template>

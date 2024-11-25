<template>
  <div class="app_frame" id="app">
    <div class="docs">
      <HeaderApp />
    </div>
    <div class="main_frame">
      <div class="main_frame_top">
        <div class="cats">
          <CategoryList
            :categorys="cats"
            :url="serverURL"
            @refreshCategorys="refreshCategorys"
          />
        </div>
        <div class="specs">
          <SpecialityList
            :specialitys="specs"
            :url="serverURL"
            @refreshSpecialitys="refreshSpecialitys"
          />
        </div>
        <div class="apps">
          <AppointmentsList
            :appointments="apps"
            :doctors="docs"
            :patients="pats"
            :url="serverURL"
            @refreshAppointments="refreshAppointments"
          />
        </div>
      </div>

      <div class="main_frame_bottom">
        <div class="docs">
          <DoctorList
            :doctors="docs"
            :specialities="specs"
            :categorys="cats"
            :appointments="apps"
            :url="serverURL"
            @refreshDoctors="refreshDoctors"
            @refreshAppointments="refreshAppointments"
          />
        </div>
        <div class="pats">
          <PatientList
            :patients="pats"
            :appointments="apps"
            :url="serverURL"
            @refreshPatients="refreshPatients"
            @refreshAppointments="refreshAppointments"
          />
        </div>
      </div>
      <div class="docs">
        <FooterApp />
      </div>
    </div>
  </div>
</template>

<script>
import HeaderApp from './components/Header.vue';
import FooterApp from './components/Footer.vue';
import CategoryList from './components/Category.vue';
import SpecialityList from './components/Speciality.vue';
import DoctorList from './components/DoctorList.vue';
import PatientList from './components/PatientList.vue';
import AppointmentsList from './components/AppointmentsList.vue';

export default {
  name: 'App',
  components: {
    CategoryList,
    SpecialityList,
    FooterApp,
    HeaderApp,
    DoctorList,
    PatientList,
    AppointmentsList,
  },
  data() {
    return {
      docs: [],
      pats: [],
      cats: [],
      specs: [],
      apps: [],
      serverURL: 'http://localhost:9000/',
    };
  },
  methods: {
    fetchDocs() {
      fetch(this.serverURL+'doctor')
        .then((response) => response.json())
        .then((data) => (this.docs = data));
    },
    fetchPats() {
      fetch(this.serverURL+'patient')
        .then((response) => response.json())
        .then((data) => (this.pats = data));
    },
    fetchSpecs() {
      fetch(this.serverURL+'speciality')
        .then((response) => response.json())
        .then((data) => (this.specs = data));
    },
    fetchCats() {
      fetch(this.serverURL+'category')
        .then((response) => response.json())
        .then((data) => (this.cats = data));
    },
    fetchApps() {
      fetch(this.serverURL+'appointment')
        .then((response) => response.json())
        .then((data) => (this.apps = data));
    },
    refreshDoctors(docdata) {
      this.docs = docdata;
    },
    refreshCategorys(catdata) {
      this.cats = catdata;
    },
    refreshSpecialitys(specdata) {
      this.specs = specdata;
    },
    refreshPatients(patdata) {
      this.pats = patdata;
    },
    refreshAppointments(appdata) {
      this.apps = appdata;
    },

  },
  computed: {},
  created() {
    this.docs = this.fetchDocs();
    this.pats = this.fetchPats();
    this.specs = this.fetchSpecs();
    this.cats = this.fetchCats();
    this.apps = this.fetchApps();
  },
};
</script>

<style>
* {
  margin: 0;
}
.main_frame {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 8px;
}
.main_frame_bottom {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: baseline;
  gap: 10vh;
}
.main_frame_top {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: baseline;
  gap: 2vh;
}
.app_frame {
  display: flex;
  flex-direction: column;
  align-items: center;
  background: linear-gradient(
    to top,
    rgb(83, 162, 199),
    20%,
    rgb(165, 235, 212)
  );
  gap: 8px;
}
.main_header {
  margin: 0;
}
</style>

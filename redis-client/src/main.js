import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import { Button, Form, Field, CellGroup, CountDown } from "vant";

createApp(App)
  .use(store)
  .use(router)
  .use(Button)
  .use(Form)
  .use(Field)
  .use(CellGroup)
  .use(CountDown)
  .mount("#app");

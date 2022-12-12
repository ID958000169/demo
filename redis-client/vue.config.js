const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
});
module.exports = {
  devServer: {
    // 设置端口为8083
    port: 8083,
  },
};

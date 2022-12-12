<template>
  <van-form @submit="onSubmit">
    <van-cell-group inset>
      <van-field
        v-model="phoneNumber"
        type="tel"
        name="phoneNumber"
        placeholder="Phone Number"
        left-icon="phone-o"
        clearable="true"
      />
      <van-field v-model="sms" placeholder="Verification code">
        <template #button>
          <van-button v-if="true" disabled size="small" type="primary">
            Send code
          </van-button>
          <van-button v-if="false" size="small" type="primary">
            <van-count-down
              :time="30000"
              format="ss seconds"
              auto-start="true"
            />
          </van-button>
        </template>
      </van-field>
    </van-cell-group>
    <div style="margin: 16px">
      <van-button round block type="primary" native-type="submit">
        Submit
      </van-button>
    </div>
  </van-form>
</template>

<script src="./js/smsVerification.js"></script>

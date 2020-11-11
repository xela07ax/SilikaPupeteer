/**
 * @name alerts
 *
 * @desc Create an alert dialog and close it again.
 *
 * @see {@link https://github.com/GoogleChrome/puppeteer/blob/master/docs/api.md#class-dialog}
 */
const puppeteer = require('puppeteer');

(async () => {
  const selenoidId = '3c8482e1c87bd7e3793db3b7915274c0'
  // await puppeteer.connect()
  pbrowser = await puppeteer.connect({
    browserWSEndpoint: `ws://selenoid.host:4444/devtools/${selenoidId}`
  })
  const page = await pbrowser.newPage()
  await page.goto('https://www.google.com/')
  page.on('dialog', async dialog => {
    console.log(dialog.message())
    await dialog.dismiss()
  })
  await page.evaluate(() => alert('This message is inside an alert box'))
})()

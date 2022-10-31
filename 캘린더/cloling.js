const axios = require('axios');
const cheerio = require('cheerio');
const { getElementById } = require('domutils');

const getHTML = async (number) => {
  try {
    return await axios.get("https://youth.seoul.go.kr/site/main/customSupp/cityList?cp="+number+"&pageSize=5&polyBizSecd1=CT&csYear=2022");
  } catch (error) {
    console.error(error);
  }
}

const parsing = async (number) => {
  const html = await getHTML(number);
  const $ = cheerio.load(html.data);
  const $servicepolicy1=$(".service-policy1").children("li")

  let  courses =[];

  $servicepolicy1.each((idx,node) =>{
   courses.push({
    title :$(node).find("a").text(),
    detail :$(node).find("p").text(),
   })
  });
  console.log(courses);
  return courses;
}

const firstdata = async (page) => {
  let first = await Json.parse(parsing(page))
  document.getElementById("page"+page).innerHTML = first.title;
};

firstdata(1)




import './Homepage.css';
import SCCalender from './SCCalender';
import SCHomepageDetail from './SCHomepageDetail';

function Homepage() {
  const initalData = {
    name: '박봉선',
    address: '광주광역시 북구 OO로 OO-OO',
    age: 'OO세',
    guardian: '김선희',
    guardianPhoneNumber: '010-1234-5678',
    risk: '안전'
  }
  return (
    <div className="flex">
      <SCCalender />
      <div className="mt-6 border-r-2 border-blue-300"></div>
      <SCHomepageDetail data={initalData} />
    </div>
  );
}

export default Homepage;

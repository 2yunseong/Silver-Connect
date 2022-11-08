import './Homepage.css';
import SCCalender from './SCCalender';
import SCHomepageDetail from './SCHomepageDetail';

function Homepage() {
  return (
    <div className="flex">
      <SCCalender />
      <div className="mt-6 border-r-2 border-blue-300"></div>
      <SCHomepageDetail />
    </div>
  );
}

export default Homepage;

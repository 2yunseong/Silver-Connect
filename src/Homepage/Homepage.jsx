import Calendar from '@toast-ui/react-calendar';
import './Homepage.css';
import '@toast-ui/calendar/dist/toastui-calendar.min.css';

function Homepage() {
  return (
    <div className="mx-8">
      <div className="flex justify-between items-center">
        <DatePicker />
        <img className="h-full" src="./images/alertBar.png" alt="alertBar" />
      </div>
      <div id="calender">
        <Calendar usageStatistics={false} view={'month'} />
      </div>
    </div>
  );
}

function DatePicker() {
  return (
    <div className="flex mt-10 mb-10 px-10 py-2 bg-gray-100 w-fit rounded-full text-2xl font-bold">
      <PickerTemplete defaultDate={'2022'} dateUnit={'년'} className="mr-6" />
      <PickerTemplete defaultDate={'10'} dateUnit={'월'} />
      <PickerTemplete defaultDate={'25'} dateUnit={'일'} />
    </div>
  );
}

function PickerTemplete(prop) {
  return (
    <div className="flex">
      <div>{prop.defaultDate}</div>
      <div>{prop.dateUnit}</div>
    </div>
  );
}

export default Homepage;

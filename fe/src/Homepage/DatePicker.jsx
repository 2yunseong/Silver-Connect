function DatePicker() {
  const date = new Date();
  return (
    <div className="flex mt-10 mb-10 px-10 py-2 bg-gray-100 w-fit rounded-full text-2xl font-bold">
      <PickerTemplete defaultDate={date.getFullYear()} dateUnit={'년'} />
      <PickerTemplete defaultDate={date.getMonth() + 1} dateUnit={'월'} />
      <PickerTemplete defaultDate={date.getDate()} dateUnit={'일'} />
    </div>
  );
}

function PickerTemplete(prop) {
  return (
    <div className="flex timepicker">
      <div>{prop.defaultDate}</div>
      <div>{prop.dateUnit}</div>
    </div>
  );
}

export default DatePicker;

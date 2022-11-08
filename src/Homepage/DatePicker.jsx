function DatePicker() {
  return (
    <div className="flex mt-10 mb-10 px-10 py-2 bg-gray-100 w-fit rounded-full text-2xl font-bold">
      <PickerTemplete defaultDate={'2022'} dateUnit={'년'} />
      <PickerTemplete defaultDate={'10'} dateUnit={'월'} />
      <PickerTemplete defaultDate={'25'} dateUnit={'일'} />
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

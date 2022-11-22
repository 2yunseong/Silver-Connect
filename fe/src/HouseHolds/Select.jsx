const dummyData = {
  name: '이남희',
  address: '광주광역시 북구 문화로 71',
  age: '78',
  phone: '010-0000-0000',
  supporter: '김영희',
  supporterPhone: '010-1111-1111',
};

const Select = () => {
  return (
    <div className='flex flex-col w-3/5 h-2/5 relative top-24 left-80 border text-center pt-5 pb-20 px-20 rounded-lg font-semibold'>
      <button className='relative right-80'>{`<`}</button>
      <h2 className='font-bold text-3xl mb-8'>정보</h2>
      <div className='flex py-3'>
        <div className='w-1/3'>이름</div>
        <div className='w-2/3'>{dummyData.name}</div>
      </div>
      <div className='flex py-3'>
        <div className='w-1/3'>주소</div>
        <div className='w-2/3'>{dummyData.address}</div>
      </div>
      <div className='flex py-3'>
        <div className='w-1/3'>연세</div>
        <div className='w-2/3'>{dummyData.age}세</div>
      </div>
      <div className='flex py-3'>
        <div className='w-1/3'>연락처</div>
        <div className='w-2/3'>{dummyData.phone}</div>
      </div>
      <hr />
      <div>
        <div className='flex py-3'>
          <div className='w-1/3'>보호자</div>
          <div className='w-2/3'>{dummyData.supporter}</div>
        </div>
        <div className='flex py-3'>
          <div className='w-1/3'>보호자 연락처</div>
          <div className='w-2/3'>{dummyData.supporterPhone}</div>
        </div>
        <hr />
        <div className='flex py-3'>
          <div className='w-1/3'>위험도</div>
          <div className='w-2/3'>안전</div>
        </div>
      </div>
    </div>
  );
};

export default Select;

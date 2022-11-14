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
    <div>
      <h1>정보</h1>
      <div>
        <div>이름</div>
        <div>{dummyData.name}</div>
      </div>
      <div>
        <div>주소</div>
        <div>{dummyData.address}</div>
      </div>
      <div>
        <div>연세</div>
        <div>{dummyData.age}세</div>
      </div>
      <div>
        <div>연락처</div>
        <div>{dummyData.phone}</div>
      </div>
      <hr />
      <div>
        <div>
          <div>보호자</div>
          <div>{dummyData.supporter}</div>
        </div>
        <div>
          <div>보호자 연락처</div>
          <div>{dummyData.supporterPhone}</div>
        </div>
        <hr />
        <div>
          <div>위험도</div>
          <div>안전</div>
        </div>
      </div>
    </div>
  );
};

export default Select;

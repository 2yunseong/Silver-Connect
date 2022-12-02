import { useNavigate, useParams } from 'react-router-dom';
import useSWR from 'swr';
import fetcher from '../util/fetcher';
import residentImg from './residentImg.jpg';
import './Select.css';

const Select = () => {
  const params = useParams();
  const navigate = useNavigate();
  const { data, error } = useSWR(
    `http://133.186.219.125:8080/api/guardian/${params.id}`,
    fetcher,
  );
  const types = {
    SAFE: '안전',
    WARN: '인지',
    DANGER: '위험',
    EMERGENCY: '긴급',
  };

  if (error) return <div>error!</div>;
  if (!data) return <div>no data</div>;

  return (
    <div className="select-container flex justify-center items-center flex-col border rounded-lg py-10 shadow-lg">
      <div className="font-bold text-5xl py-3">어르신 가구 정보</div>

      <img
        className="rounded-full w-60 h-60 my-7 my-0 mx-auto"
        src={residentImg}
        alt="profile"
      />
      <div className="flex py-3 w-3/5 bmx-auto my-0 border-b">
        <div className="w-1/3 font-bold">이름</div>
        <div className="w-2/3">{data.household.residentName}</div>
      </div>
      <div className="flex py-3 w-3/5 mx-auto my-0 border-b">
        <div className="w-1/3 font-bold">주소</div>
        <div className="w-2/3">{data.household.address}</div>
      </div>
      <div className="flex py-3 w-3/5 mx-auto my-0 border-b">
        <div className="w-1/3 font-bold">연세</div>
        <div className="w-2/3">{data.household.residentAge}세</div>
      </div>
      <div className="flex py-3 w-3/5 mx-auto my-0 border-b">
        <div className="w-1/3 font-bold">연락처</div>
        <div className="w-2/3">{data.household.residentPhoneNumber}</div>
      </div>
      <div className="flex py-3 w-3/5 mx-auto my-0 border-b">
        <div className="w-1/3 font-bold">보호자</div>
        <div className="w-2/3">{data.name}</div>
      </div>
      <div className="flex py-3 w-3/5 mx-auto my-0 border-b">
        <div className="w-1/3 font-bold">보호자 연락처</div>
        <div className="w-2/3">{data.phoneNumber}</div>
      </div>
      <hr />
      <div className="flex py-3 w-3/5 mx-auto my-0 border-b">
        <div className="w-1/3 font-bold">위험도</div>
        <div className="flex">
          <div
            className={`w-6 h-89 rounded-full mr-2 ${data.household.risk}`}
          />
          <div>{types[data.household.risk]}</div>
        </div>
      </div>
      <div>
        <button className="text-2xl text-black bg-slate-200 border-gray rounded-lg w-36 mx-auto mt-10 py-3 mr-4">
          수정하기
        </button>
        <button
          className="text-2xl text-white bg-blue-500 border-blue rounded-lg w-36 mx-auto mt-10 py-3"
          onClick={() => {
            navigate('/household');
          }}
        >
          뒤로가기
        </button>
      </div>
    </div>
  );
};

export default Select;

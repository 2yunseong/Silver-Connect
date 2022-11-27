import { useNavigate, useParams } from 'react-router-dom';
import useSWR from 'swr';
import fetcher from '../util/fetcher';

const Select = () => {
  const params = useParams();
  const navigate = useNavigate();
  const { data, error } = useSWR(
    `http://133.186.219.125:8080/api/guardian/${params.id}`,
    fetcher
  );

  if (error) return <div>error!</div>;
  if (!data) return <div>no data</div>;

  return (
    <div className='flex flex-col w-3/5 h-2/5 relative top-24 left-80 border text-center pt-5 pb-20 px-20 rounded-lg font-semibold'>
      <button
        className='relative right-80'
        onClick={() => {
          navigate('/household');
        }}
      >{`<`}</button>
      <h2 className='font-bold text-3xl mb-8'>정보</h2>
      <div className='flex py-3'>
        <div className='w-1/3'>이름</div>
        <div className='w-2/3'>{data.household.residentName}</div>
      </div>
      <div className='flex py-3'>
        <div className='w-1/3'>주소</div>
        <div className='w-2/3'>{data.household.address}</div>
      </div>
      <div className='flex py-3'>
        <div className='w-1/3'>연세</div>
        <div className='w-2/3'>{data.household.residentAge}세</div>
      </div>
      <div className='flex py-3'>
        <div className='w-1/3'>연락처</div>
        <div className='w-2/3'>{data.household.residentPhoneNumber}</div>
      </div>
      <hr />
      <div>
        <div className='flex py-3'>
          <div className='w-1/3'>보호자</div>
          <div className='w-2/3'>{data.name}</div>
        </div>
        <div className='flex py-3'>
          <div className='w-1/3'>보호자 연락처</div>
          <div className='w-2/3'>{data.phoneNumber}</div>
        </div>
        <hr />
        <div className='flex py-3'>
          <div className='w-1/3'>위험도</div>
          <div className='w-2/3'>{data.household.risk}</div>
        </div>
      </div>
    </div>
  );
};

export default Select;

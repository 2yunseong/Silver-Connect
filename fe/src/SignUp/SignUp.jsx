import { useNavigate } from 'react-router-dom';
import useInput from '../Hooks/useInput';
import './SignUp.css';

const SignUp = () => {
  const navigate = useNavigate();
  const email = useInput();
  const password = useInput();
  const name = useInput();
  const phoneNumber = useInput();

  const onSignUp = () => {
    fetch('http://133.186.219.125:8080/api/user', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        email: email.value,
        password: password.value,
        name: name.value,
        phoneNumber: phoneNumber.value,
      }),
    }).then((response) => {
      console.log(response.json());
      alert('회원가입 완료.');
      navigate(-1);
    });
  };

  return (
    <div className='sign-up-container mx-auto my-10 justify-center text-center rounded-lg border shadow-lg'>
      <h1 className='font-bold text-5xl m-20'>회원 가입</h1>
      <div className='flex flex-col w-full'>
        <div className='flex justify-center text-justify w-3/5 mx-auto text-2xl my-6'>
          <span className='w-1/3'>이름:</span>
          <input
            className='border-b pb-2'
            type='text'
            placeholder='이름'
            onChange={name.onChange}
            value={name.value}
          />
        </div>
        <div className='flex justify-center text-justify w-3/5 mx-auto text-2xl my-6'>
          <span className='w-1/3'>연락처:</span>
          <input
            className='border-b pb-2'
            type='text'
            placeholder='ex) 010-1234-1234'
            onChange={phoneNumber.onChange}
            value={phoneNumber.value}
          />
        </div>
        <div className='flex justify-center text-justify w-3/5 mx-auto text-2xl my-6'>
          <span className='w-1/3'>이메일(ID):</span>
          <input
            className='border-b pb-2'
            type='text'
            placeholder='example@jnu.ac.kr'
            onChange={email.onChange}
            value={email.value}
          />
        </div>
        <div className='flex justify-center text-justify w-3/5 mx-auto text-2xl my-6'>
          <span className='w-1/3'>비밀번호:</span>
          <input
            className='border-b pb-2'
            type='password'
            placeholder='비밀번호'
            onChange={password.onChange}
            value={password.value}
          />
        </div>
        <div className='flex justify-center text-justify w-3/5 mx-auto text-2xl my-6'>
          <span className='w-1/3'>비밀번호 확인:</span>
          <input
            className='border-b pb-2'
            type='password'
            placeholder='비밀번호 확인'
          />
        </div>
        <button
          className='text-white bg-blue-500 border-blue rounded-xl w-96 mx-auto mt-8 mb-20 h-12'
          onClick={onSignUp}
        >
          회원가입
        </button>
      </div>
    </div>
  );
};

export default SignUp;

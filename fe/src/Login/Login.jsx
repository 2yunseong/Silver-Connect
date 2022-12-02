import { useNavigate } from 'react-router-dom';
import useInput from '../Hooks/useInput';
import './Login.css';

const Login = ({ setIsLogin }) => {
  const navigate = useNavigate();
  const email = useInput();
  const password = useInput();

  const onLogin = () => {
    setIsLogin(true);
    navigate('/');
  };

  const onSignUp = () => {
    navigate('/signup');
  };

  return (
    <div className='login-container mx-auto justify-center text-center rounded-lg border shadow-lg'>
      <h1 className='font-bold text-5xl my-16'>로그인</h1>
      <div className='flex flex-col w-full mx-auto my-0'>
        <div className='flex justify-center w-full mx-auto my-6 text-2xl'>
          <span className='font-semibold'>이메일(ID):</span>
          <input
            className='border-b pb-2'
            type='text'
            placeholder='example@jnu.ac.kr'
            onChange={email.onChange}
            value={email.value}
          />
        </div>

        <div className='flex justify-center w-full mx-auto my-6 text-2xl'>
          <span className='font-semibold'>비밀번호:</span>
          <input
            className='border-b pb-2'
            type='password'
            placeholder='비밀번호'
            onChange={password.onChange}
            value={password.value}
          />
        </div>
        <button
          className='text-white bg-blue-500 border-blue rounded-xl w-80 mx-auto my-6 h-10'
          onClick={onLogin}
        >
          로그인
        </button>
        <button
          className='text-white bg-blue-500 border-blue rounded-xl w-80 mx-auto mt-3 mb-20 h-10'
          onClick={onSignUp}
        >
          회원가입
        </button>
      </div>
    </div>
  );
};

export default Login;
